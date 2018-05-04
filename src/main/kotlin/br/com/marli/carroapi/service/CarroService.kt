package br.com.marli.carroapi.service

import br.com.marli.carroapi.entity.Carro
import br.com.marli.carroapi.repository.CarroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarroService{

    @Autowired
    lateinit var carroRepository: CarroRepository

    fun buscarTodosCarros(): List<Carro>{
        return carroRepository.findAll()
    }

    fun buscarCarroPorMarca(marca:String): List<Carro>{
        return carroRepository.findByMarcaContaining(marca)

    }

    fun buscarCarroPorPlaca(placa:String):List<Carro>{
        return carroRepository.findByPlaca(placa)
    }

    fun buscarcarroPorAno(ano: Int): List<Carro>{
        return carroRepository.findByAno(ano)
    }

    fun salvar(carro: Carro){
        carroRepository.save(carro)
    }

}