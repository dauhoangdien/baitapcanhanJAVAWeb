package com.example.Dien_7356.service;
import com.example.Dien_7356.model.NhanVien;
import com.example.Dien_7356.repository.NhanVienRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    // Retrieve all NhanVien from the database
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }
    // Retrieve a NhanVien by its id
    public Optional<NhanVien> getNhanVienById(String id) {
        return nhanVienRepository.findById(id);
    }
    // Add a new NhanVien to the database
    public NhanVien addProduct(@Valid NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }
    // Update an existing NhanVien
    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getMaNV())
                .orElseThrow(() -> new IllegalStateException("Nhân viên với mã: " +
                        nhanVien.getMaNV() + " không tồn tại."));
        existingNhanVien.setTenNV(nhanVien.getTenNV());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPb(nhanVien.getPb());
        return nhanVienRepository.save(existingNhanVien);
    }
    // Delete a NhanVien by its id
    public void deleteNhanVienById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Nhân Viên với id: " + id + " không tồn tại.");
        }
        nhanVienRepository.deleteById(id);
    }
    public Optional<NhanVien> searchNhanVienByTenNV(String keyword) throws
            UsernameNotFoundException {
        return Optional.ofNullable(nhanVienRepository.searchNhanVienByTenNV(keyword));
    }
}