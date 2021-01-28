package com.mitocode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Menu;
import com.mitocode.model.Rol;

public interface IMenuRepo extends IGenericRepo<Menu, Integer>{

	@Query(value="select m.* from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre", nativeQuery = true)
	List<Menu> listarMenuPorUsuario(@Param("nombre") String nombre);

	@Query(value="select ro.* from usuario u inner join usuario_rol ur on u.id_usuario = ur.id_usuario inner join rol ro on ur.id_rol = ro.id_rol where u.nombre = :nombre", nativeQuery = true)
	Rol obtenerRolUsuario(@Param("nombre") String nombre);
	
}
