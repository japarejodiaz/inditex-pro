package com.inditex.zarachallenge.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SIZE")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIZE_ID")
    private Long sizeId;

    @Column(name = "SIZE", nullable = false)
    private String size;

    @Column(name = "AVAILABILITY")
    private boolean availability;

    @Column(name = "LAST_UPDATED")
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity productEntity;

}
