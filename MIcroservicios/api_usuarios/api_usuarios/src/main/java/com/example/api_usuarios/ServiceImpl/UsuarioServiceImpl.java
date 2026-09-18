package com.example.api_usuarios.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.api_usuarios.DTO.usuarioDTO.UsuarioDTOMapper;
import com.example.api_usuarios.DTO.usuarioDTO.getUsuarioDTO;
import com.example.api_usuarios.DTO.usuarioDTO.getUsuarioDTOAdmin;
import com.example.api_usuarios.DTO.usuarioDTO.postUsuarioDTO;
import com.example.api_usuarios.DTO.usuarioDTO.putUsuarioDTO;
import com.example.api_usuarios.DTO.usuarioDTO.putUsuarioDTOAdmin;
import com.example.api_usuarios.Model.Region;
import com.example.api_usuarios.Model.Usuario;
import com.example.api_usuarios.Repository.RegionRepository;
import com.example.api_usuarios.Repository.UsuarioRepository;
import com.example.api_usuarios.Service.UsuarioService;

@Service 
public class UsuarioServiceImpl implements UsuarioService {

    // Inyeccion de repositorios y dependencias
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private UsuarioDTOMapper usuarioDTOMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // metodos GET
    @Override
    public List<getUsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<getUsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario u : usuarios) {
            usuariosDTO.add(usuarioDTOMapper.toGetUsuarioDTO(u));
        }
        return usuariosDTO;
    }

    @Override
    public List<getUsuarioDTOAdmin> getAllUsuariosAdmin() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<getUsuarioDTOAdmin> usuariosAdminDTO = new ArrayList<>();

        for (Usuario u : usuarios) {
            usuariosAdminDTO.add(usuarioDTOMapper.toGetUsuarioDTOAdmin(u));
        }
        return usuariosAdminDTO;
    }

    @Override
    public getUsuarioDTO getUsuarioById(Long id_usuario) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id_usuario));

        return usuarioDTOMapper.toGetUsuarioDTO(usuario);
    }

    @Override
    public getUsuarioDTOAdmin getUsuarioByIdAdmin(Long id_usuario) {
        Usuario usuario = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id_usuario));

        return usuarioDTOMapper.toGetUsuarioDTOAdmin(usuario);
    }
    // --- FIN GET


    // metodos POST
    @Override
    public getUsuarioDTO saveUsuario(postUsuarioDTO postUsuarioDTO) {
        // Validar que la region exista
        Region region = regionRepository.findById(postUsuarioDTO.getId_region())
                .orElseThrow(() -> new RuntimeException("Region no encontrada con id: " + postUsuarioDTO.getId_region()));

        // Mapear DTO a Entidad aplicando cifrado de contrasena
        Usuario usuario = usuarioDTOMapper.toEntity(postUsuarioDTO, region);

        // Guardar entidad
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Retornar DTO sin password
        return usuarioDTOMapper.toGetUsuarioDTO(usuarioGuardado);
    }


    // metodos PUT
    @Override
    public getUsuarioDTO putUsuario(putUsuarioDTO putUsuarioDTO, Long id_usuario) {
        Usuario usuario_existente = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id_usuario));

        Region region = regionRepository.findById(putUsuarioDTO.getId_region())
                .orElseThrow(() -> new RuntimeException("Region no encontrada con id: " + putUsuarioDTO.getId_region()));

        // Actualizacion de atributos
        usuario_existente.setP_nombre(putUsuarioDTO.getP_nombre());
        usuario_existente.setS_nombre(putUsuarioDTO.getS_nombre());
        usuario_existente.setP_apellido(putUsuarioDTO.getP_apellido());
        usuario_existente.setS_apellido(putUsuarioDTO.getS_apellido());
        usuario_existente.setCorreo_elec(putUsuarioDTO.getCorreo_elec());
        usuario_existente.setNum_telefono(putUsuarioDTO.getNum_telefono());

        // Si se envia nueva contrasena, se encripta
        if (putUsuarioDTO.getContrasena() != null && !putUsuarioDTO.getContrasena().isEmpty()) {
            usuario_existente.setContrasena(passwordEncoder.encode(putUsuarioDTO.getContrasena()));
        }

        usuario_existente.setRegion_usuario(region);

        Usuario usuarioActualizado = usuarioRepository.save(usuario_existente);
        return usuarioDTOMapper.toGetUsuarioDTO(usuarioActualizado);
    }

    @Override
    public getUsuarioDTOAdmin putUsuarioAdmin(putUsuarioDTOAdmin putUsuarioDTOAdmin, Long id_usuario) {
        Usuario usuario_existente = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id_usuario));

        Region region = regionRepository.findById(putUsuarioDTOAdmin.getId_region())
                .orElseThrow(() -> new RuntimeException("Region no encontrada con id: " + putUsuarioDTOAdmin.getId_region()));

        // Actualizacion de atributos
        usuario_existente.setP_nombre(putUsuarioDTOAdmin.getP_nombre());
        usuario_existente.setS_nombre(putUsuarioDTOAdmin.getS_nombre());
        usuario_existente.setP_apellido(putUsuarioDTOAdmin.getP_apellido());
        usuario_existente.setS_apellido(putUsuarioDTOAdmin.getS_apellido());
        usuario_existente.setCorreo_elec(putUsuarioDTOAdmin.getCorreo_elec());
        usuario_existente.setNum_telefono(putUsuarioDTOAdmin.getNum_telefono());

        if (putUsuarioDTOAdmin.getContrasena() != null && !putUsuarioDTOAdmin.getContrasena().isEmpty()) {
            usuario_existente.setContrasena(passwordEncoder.encode(putUsuarioDTOAdmin.getContrasena()));
        }

        if (putUsuarioDTOAdmin.getPermiso_admin() != null) {
            usuario_existente.setPermiso_admin(putUsuarioDTOAdmin.getPermiso_admin());
        }

        usuario_existente.setRegion_usuario(region);

        Usuario usuarioActualizado = usuarioRepository.save(usuario_existente);
        return usuarioDTOMapper.toGetUsuarioDTOAdmin(usuarioActualizado);
    }


    // metodos DELETE
    @Override
    public void deleteUsuario(Long id_usuario) {
        Usuario usuario_eliminado = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id_usuario));

        usuarioRepository.delete(usuario_eliminado);
    }

}
