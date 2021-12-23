package br.com.gerencianet.tabelafipe.domain.usecase

import br.com.gerencianet.tabelafipe.base.BaseUseCase
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel
import br.com.gerencianet.tabelafipe.domain.repository.FipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetManufacturersListUseCase @Inject constructor(val mFipeRepository: FipeRepository) :
    BaseUseCase<List<ManufacturerModel>, BaseUseCase.None>() {
    override fun doWork(params: BaseUseCase.None): Flow<List<ManufacturerModel>?> = flow {
        emit(
            mFipeRepository.getManufacturerList()
        )
    }
}
