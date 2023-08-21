package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UsuarioRepositoryTest {

    val mockDao = mockk<UsuarioDao>()
    val usuario = Usuario(
        id = "1",
        email = "teste@teste.com.br",
        senha = "123456"
    )

    @Test
    fun `deve salvar um usuario quando chamado o salva do repository`() = runTest {
        coEvery { mockDao.salva(usuario) } returns Unit

        val usuarioRepository = UsuarioRepository(mockDao)
        usuarioRepository.salva(usuario)

        coVerify(exactly = 1) { mockDao.salva(usuario) }
    }

    @Test
    fun `deve logar um usuario quando chamado o autentica do repository`() = runTest {
        coEvery { mockDao.autentica(usuario.id, usuario.senha) } returns mockk ()

        val usuarioRepository = UsuarioRepository(mockDao)
        usuarioRepository.autentica(usuario.id, usuario.senha)

        coVerify(exactly = 1) { mockDao.autentica(usuario.id, usuario.senha) }
    }
}