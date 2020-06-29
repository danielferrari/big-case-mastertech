# Big case - Emissão de notas fiscais
Projeto baseado em microsserviços que realiza e emissão de notas fiscais.

## nfe
Responsável pela emissão e consulta das notas fiscais, além de ser o único microsserviço responsável por gravar no banco de dados

## nfe-calculo
Responsável por receber reativamente as notas fiscais, realizar o calculo dos impostos devidos e atualizar o status no banco de dados chamando o microsserviço de emissão (nfe)

## config-provider
Provider de configuração

## service-discovery
Servidor de service discovery construído com Eureka

## api-gateway
Serviço de api-gateway feito com Zuul Proxy