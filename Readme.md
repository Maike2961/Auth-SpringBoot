# 🔐 Projeto de Autenticação com Spring Authorization Server

Este projeto é uma aplicação de autenticação construída com **Spring Boot** e **Spring Authorization Server**, que suporta:

- Autenticação via **usuário/senha** (`password`)
- Autenticação via **Client Credentials** (`client_credentials`)
- Emissão de **JWTs** como tokens de acesso
- Suporte a **OpenID Connect (OIDC)** (opcional)
- Autenticação via formulário (`formLogin`) ou via OAuth2

---

## 📦 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security
- Spring Authorization Server
- OAuth2 / OIDC
- JWT (JSON Web Token)

---

## ⚙️ Funcionalidades

- 🔐 Autenticação de usuários via formulário ou endpoint de token (`/oauth2/token`)
- 🔑 Autenticação de clientes via `client_id` e `client_secret`
- 📄 Emissão de tokens JWT com claims personalizados
- ✅ Rotas protegidas com validação de JWT
- 🛡️ Configuração de múltiplos fluxos de autenticação OAuth2

---

## 🧪 Fluxos de Autenticação

### 1. Senha do Usuário (Password Credentials)

> Fluxo: Usuário fornece e-mail e senha. O sistema valida e retorna um token de acesso.

```bash

manualmente:

POST /oauth2/token

header: 

Authorization: <AUTH_BASIC>

body:
Content-Type: application/x-www-form-urlencoded

grant_type: client_credentials
scope: <usuario.getRole()>