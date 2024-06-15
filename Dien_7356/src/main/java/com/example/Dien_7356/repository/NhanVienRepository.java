package com.example.Dien_7356.repository;
import com.example.Dien_7356.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    NhanVien searchNhanVienByTenNV(String keyword);
}