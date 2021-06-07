package br.com.havebreak.forum.config.validacao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErroDeValidacaoHandler {

    @Autowired
    lateinit var messageSource: MessageSource

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)//Método é chamado quando ocorre alguma exceção dentro de algum controller
    fun handle(exception: MethodArgumentNotValidException): List<ErroDeFormularioDto> {
        val dto = ArrayList<ErroDeFormularioDto>();
        val fieldErros = exception.bindingResult.fieldErrors
        fieldErros.forEach {
            val mensagem = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            val erro = ErroDeFormularioDto(it.field, mensagem)
            dto.add(erro)
        }
        return dto
    }
}