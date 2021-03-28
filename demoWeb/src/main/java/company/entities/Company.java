package company.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Company implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Bạn chưa nhập tên công ty.")
    private String name;
    @NotBlank(message = "Bạn chưa nhập mã số thuế.")
    private String taxCode;
    @Min(value = 0, message = "Vốn điều lệ phải là số dương.")
    @NotNull(message = "Vốn điều lệ không hợp lệ.")
    private Float AuthorizedCapital;
    @NotBlank(message = "Bạn chưa nhập lĩnh vực hoạt động.")
    private String operationField;
    @Min(value = 0, message = "Sô nhân viên phải là số dương.")
    @NotNull(message = "Sô nhân viên không hợp lệ.")
    private Integer staffAmount;
    @NotBlank(message = "Bạn chưa nhập địa chỉ.")
    private String address;
    @NotBlank(message = "Bạn chưa nhập số điện thoại.")
    private String phone;
    @Min(value = 0, message = "Diện tích mặt bằng phải là số dương.")
    @NotNull(message = "Diện tích mặt bằng không hợp lệ.")
    private Integer groundArea;

    public Company() {
    }

    public Company(String name, Long id, String taxCode, Float authorizedCapital, String operationField,
            Integer staffAmount, String address, String phone, Integer groundArea) {
        this.name = name;
        this.id = id;
        this.taxCode = taxCode;
        this.AuthorizedCapital = authorizedCapital;
        this.operationField = operationField;
        this.staffAmount = staffAmount;
        this.address = address;
        this.phone = phone;
        this.groundArea = groundArea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Float getAuthorizedCapital() {
        return AuthorizedCapital;
    }

    public void setAuthorizedCapital(Float authorizedCapital) {
        AuthorizedCapital = authorizedCapital;
    }

    public String getOperationField() {
        return operationField;
    }

    public void setOperationField(String operationField) {
        this.operationField = operationField;
    }

    public Integer getStaffAmount() {
        return staffAmount;
    }

    public void setStaffAmount(Integer staffAmount) {
        this.staffAmount = staffAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGroundArea() {
        return groundArea;
    }

    public void setGroundArea(Integer groundArea) {
        this.groundArea = groundArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
