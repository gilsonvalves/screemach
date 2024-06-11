package br.com.gilsonvalves.screemach.service;

public interface IConverteDados {
   <T>  T obterDados(String json,Class<T> classe);
}
