package com.fleet.vehicle_service_csm.VehicleEntity.specification;

import com.fleet.vehicle_service_csm.VehicleEntity.model.Vehicle;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecification {
    public static Specification<Vehicle> hasLicensePlate(String licensePlate) {
        return ((root, query, criteriaBuilder) ->
                licensePlate==null ? null : criteriaBuilder.equal(root.get("licensePlate"), licensePlate));
    }

    public static Specification<Vehicle> hasManufacturer(String manufacturer) {
        return ((root, query, criteriaBuilder) ->
                manufacturer==null ? null : criteriaBuilder.equal(root.get("manufacturer"), manufacturer));
    }

    public static Specification<Vehicle> hasStatus(String status) {
        return ((root, query, criteriaBuilder) ->
                status==null ? null : criteriaBuilder.equal(root.get("status"), status));
    }

    public static Specification<Vehicle> hasYear(Integer year) {
        return ((root, query, criteriaBuilder) ->
                year==null ? null : criteriaBuilder.equal(root.get("year"), year));
    }
}
