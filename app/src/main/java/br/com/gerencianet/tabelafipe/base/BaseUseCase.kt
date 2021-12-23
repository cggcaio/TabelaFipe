package br.com.gerencianet.tabelafipe.base

import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.*


abstract class BaseUseCase<Type : Any, Params : Any?> : UseCase<Type> {
    private val channel = ConflatedBroadcastChannel<Params>()

    operator fun invoke(params: Params) = channel.sendBlocking(params)

    protected abstract fun doWork(params: Params): Flow<Type?>

    fun produce(params: Params): Flow<Type?> = doWork(params = params)
        .flowOn(dispatcher)

    override fun observe(): Flow<Type?> = channel.asFlow()
        .distinctUntilChanged()
        .flatMapLatest { doWork(it) }
        .flowOn(dispatcher)

    object None
}
