package com.mathroda.dashcoin.infrastructure.worker

import androidx.work.*
import com.mathroda.dashcoin.core.util.Constants
import com.mathroda.dashcoin.domain.repository.WorkerProviderRepository
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WorkerProviderRepositoryImpl @Inject constructor(
    private val workManager: WorkManager
): WorkerProviderRepository {

    private val workConstraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresBatteryNotLow(true)
        .build()


    override fun createWork() {
        val workRequest = PeriodicWorkRequestBuilder<DashCoinWorker>(
            15, TimeUnit.MINUTES,
            15, TimeUnit.MINUTES
        ).setConstraints(workConstraints).setInitialDelay(15,TimeUnit.MINUTES)
            .addTag(Constants.SYNC_DATA).build()

        workManager.enqueueUniquePeriodicWork(
            Constants.SYNC_DATA_WORK_NAME,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }

    override fun onWorkerSuccess() = workManager.getWorkInfosByTagLiveData(Constants.SYNC_DATA)
}