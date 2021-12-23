package br.com.gerencianet.tabelafipe.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Flow

interface UseCase<Type> {
    val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    fun observe(): Flow<Type?>
}
