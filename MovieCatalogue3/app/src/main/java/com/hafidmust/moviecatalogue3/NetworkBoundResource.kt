package com.hafidmust.moviecatalogue3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.hafidmust.moviecatalogue3.data.source.remote.ApiResponse
import com.hafidmust.moviecatalogue3.data.source.remote.StatusResponse
import com.hafidmust.moviecatalogue3.utils.AppExecutors
import com.hafidmust.moviecatalogue3.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        val dbSource = loadFromDB()

        result.addSource(dbSource){data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)){
                fetchFromNetwork(dbSource)
            }else{
                result.addSource(dbSource){newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    private fun  onFetchFailed(){}

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>){
        val apiResponse = createCall()

        result.addSource(dbSource){newData ->
            result.value = Resource.loading(newData)
        }

        result.addSource(apiResponse){response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when(response.status){
                StatusResponse.SUCCESS->
                    mExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()){newData->
                                result.value = Resource.success(newData)
                            }
                        }
                    }
                StatusResponse.EMPTY->{
                    onFetchFailed()
                    result.addSource(dbSource){newData->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)
}