package com.co.edu.udea.granjamintic.sistema.utils;

import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.modelo.Rol;

public class PersonaBuilder {

	public static Persona convertirAEntidad(OidcUserInfo oidcUserInfo) {
		String outh0Id = oidcUserInfo.getSubject();
		String nombres = oidcUserInfo.getGivenName();
		String apellidos = oidcUserInfo.getFamilyName();
		String correoElectronico = oidcUserInfo.getEmail();
		String urlFoto = oidcUserInfo.getPicture();
		return new Persona (outh0Id, nombres, apellidos, correoElectronico, urlFoto, Rol.ADMINISTRADOR);
	}
	

}
