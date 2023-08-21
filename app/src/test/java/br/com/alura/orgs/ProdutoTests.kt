package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTests {

    @Test
    fun `deve retornar verdadeiro quando valor for valido`() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorValido

//        Junit
//        assertTrue(valorEhValido)

//        Kluent
//        valorEhValido shouldBeEqualTo true
//        valorEhValido.shouldBeEqualTo(true)
        valorEhValido.shouldBeTrue()

    }

    @Test
    fun `deve retornar falso quando valor for maior que cem`() {
        //Arrange
        val produtoInvalido = Produto(
            nome = "Morango",
            descricao = "Vermelho",
            valor = BigDecimal("105.99")
        )

        //Act
        val valorEhInvalido = produtoInvalido.valorValido

        //Assert
//        Junit
//        assertFalse(valorEhInvalido)

//        Kluent
//        valorEhInvalido shouldBeEqualTo false
        valorEhInvalido.shouldBeFalse()
    }


    @Test
    fun `deve retornar falso quando valor for menor ou igual zero`() {
        //Arrange
        val produtoComValorIgualZero = Produto(
            nome = "Pera",
            descricao = "Argentina",
            valor = BigDecimal("0.00")
        )
        val produtoComValorNegativo = Produto(
            nome = "Ameixa",
            descricao = "Seca",
            valor = BigDecimal("-1.00")
        )

        //Act
        val produtoComValorIgualZeroEhValido = produtoComValorIgualZero.valorValido
        val produtoComValorNegativoEhValido = produtoComValorNegativo.valorValido

        //Assert
//        JUnit
//        assertFalse(produtoComValorIgualZeroEhValido)
//        assertFalse(produtoComValorNegativoEhValido)

//        Kluent
//        produtoComValorIgualZeroEhValido shouldBeEqualTo false
//        produtoComValorNegativoEhValido shouldBeEqualTo false
        produtoComValorIgualZeroEhValido.shouldBeFalse()
        produtoComValorNegativoEhValido.shouldBeFalse()
    }
}