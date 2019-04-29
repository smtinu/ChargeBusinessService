package com.vz.intrada.charge.controller;

public class ChargeBO {
	
	private String chargeId;
    /** Private data attribute for Customer Id. */
    private Long customerId;
    /** Private data attribute for Billing Tn Id. */
    private String billingTnId;
    /** Private data attribute for Charge Code. */
    private Integer chargeCode;
    /** Private data attribute for Charge Type. */
    private String chargeType;
    /** Private data attribute for Charge Sub Type. */
    private String chargeSubType;
    /** Private data attribute for Charge Desc. */
    private String chargeDesc;
    /** Private data attribute for Source. */
    private String source;
    /** Private data attribute for Recurring Flag. */
    private Boolean recurringFlag;
    /** Private data attribute for Taxable Flag. */
    private Boolean taxableFlag;
    /** Private data attribute for Waived Flag. */
    private Boolean waivedFlag;
    /** Private data attribute for Prorate Flag. */
    private Boolean prorateFlag;
    /** Private data attribute for Monthly Amount. */
    private Double monthlyAmount;
    /** Private data attribute for Original Amount. */
    private Double originalAmount;
    /** Private data attribute for Total Amount. */
    private Double totalAmount;
    /** Private data attribute for Minimum Amount. */
    private Double minimumAmount;
    /** Private data attribute for Maximum Amount. */
    private Double maximumAmount;
    /** Private data attribute for Effective Date. */
    private java.sql.Date effectiveDate;
    /** Private data attribute for Deactivate Date. */
    private java.sql.Date deactivateDate;
    /** Private data attribute for First Billed Date. */
    private java.sql.Date firstBilledDate;
    /** Private data attribute for Billed Through Date. */
    private java.sql.Date billedThroughDate;
    /** Private data attribute for Discount Type. */
    private Integer discountType;
    /** Private data attribute for Product Code. */
    private Integer productCode;
    /** Private data attribute for Usoc. */
    private String usoc;
    /** Private data attribute for Quantity. */
    private Integer quantity;
    /** Private data attribute for Present In Bill System Flag. */
    private boolean presentInBillSystemFlag;
    /** Private data attribute for Validated Flag. */
    private Boolean validatedFlag;
    /** Private data attribute for Action Code. */
    private String actionCode;
    /** Private data attribute for Sub Type Code. */
    private String subTypeCode;
    /** Private data attribute for Bill System Last Update Date. */
    private java.sql.Timestamp billSystemLastUpdateDate;
    /** Private data attribute for Sequence Number. */
    private Integer sequenceNumber;
    /** Private data attribute for Circuit Id. */
    private String circuitId;
    /** Private data attribute for Submit Status. */
    private String submitStatus;
    /** Private data attribute for Reference Number. */
    private String referenceNumber;
    /** Private data attribute for Unit Original Amount. */
    private Double unitOriginalAmount;
    /** Private data attribute for Unit Monthly Amount. */
    private Double unitMonthlyAmount;
    /** Private data attribute for Charge Quantity. */
    private Integer chargeQuantity;
    /** Private data attribute for the Embellished Description of DiscountType. */
    private String discountTypeDesc;
    /** Private data attribute for the Embellished Description of ProductCode. */
    private String productCodeDesc;
    
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getBillingTnId() {
		return billingTnId;
	}
	public void setBillingTnId(String billingTnId) {
		this.billingTnId = billingTnId;
	}
	public Integer getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(Integer chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getChargeType() {
		return chargeType;
	}
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	public String getChargeSubType() {
		return chargeSubType;
	}
	public void setChargeSubType(String chargeSubType) {
		this.chargeSubType = chargeSubType;
	}
	public String getChargeDesc() {
		return chargeDesc;
	}
	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Boolean getRecurringFlag() {
		return recurringFlag;
	}
	public void setRecurringFlag(Boolean recurringFlag) {
		this.recurringFlag = recurringFlag;
	}
	public Boolean getTaxableFlag() {
		return taxableFlag;
	}
	public void setTaxableFlag(Boolean taxableFlag) {
		this.taxableFlag = taxableFlag;
	}
	public Boolean getWaivedFlag() {
		return waivedFlag;
	}
	public void setWaivedFlag(Boolean waivedFlag) {
		this.waivedFlag = waivedFlag;
	}
	public Boolean getProrateFlag() {
		return prorateFlag;
	}
	public void setProrateFlag(Boolean prorateFlag) {
		this.prorateFlag = prorateFlag;
	}
	public Double getMonthlyAmount() {
		return monthlyAmount;
	}
	public void setMonthlyAmount(Double monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
	public Double getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getMinimumAmount() {
		return minimumAmount;
	}
	public void setMinimumAmount(Double minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	public Double getMaximumAmount() {
		return maximumAmount;
	}
	public void setMaximumAmount(Double maximumAmount) {
		this.maximumAmount = maximumAmount;
	}
	public java.sql.Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(java.sql.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public java.sql.Date getDeactivateDate() {
		return deactivateDate;
	}
	public void setDeactivateDate(java.sql.Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}
	public java.sql.Date getFirstBilledDate() {
		return firstBilledDate;
	}
	public void setFirstBilledDate(java.sql.Date firstBilledDate) {
		this.firstBilledDate = firstBilledDate;
	}
	public java.sql.Date getBilledThroughDate() {
		return billedThroughDate;
	}
	public void setBilledThroughDate(java.sql.Date billedThroughDate) {
		this.billedThroughDate = billedThroughDate;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public Integer getProductCode() {
		return productCode;
	}
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}
	public String getUsoc() {
		return usoc;
	}
	public void setUsoc(String usoc) {
		this.usoc = usoc;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isPresentInBillSystemFlag() {
		return presentInBillSystemFlag;
	}
	public void setPresentInBillSystemFlag(boolean presentInBillSystemFlag) {
		this.presentInBillSystemFlag = presentInBillSystemFlag;
	}
	public Boolean getValidatedFlag() {
		return validatedFlag;
	}
	public void setValidatedFlag(Boolean validatedFlag) {
		this.validatedFlag = validatedFlag;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getSubTypeCode() {
		return subTypeCode;
	}
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	public java.sql.Timestamp getBillSystemLastUpdateDate() {
		return billSystemLastUpdateDate;
	}
	public void setBillSystemLastUpdateDate(java.sql.Timestamp billSystemLastUpdateDate) {
		this.billSystemLastUpdateDate = billSystemLastUpdateDate;
	}
	public Integer getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getCircuitId() {
		return circuitId;
	}
	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}
	public String getSubmitStatus() {
		return submitStatus;
	}
	public void setSubmitStatus(String submitStatus) {
		this.submitStatus = submitStatus;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public Double getUnitOriginalAmount() {
		return unitOriginalAmount;
	}
	public void setUnitOriginalAmount(Double unitOriginalAmount) {
		this.unitOriginalAmount = unitOriginalAmount;
	}
	public Double getUnitMonthlyAmount() {
		return unitMonthlyAmount;
	}
	public void setUnitMonthlyAmount(Double unitMonthlyAmount) {
		this.unitMonthlyAmount = unitMonthlyAmount;
	}
	public Integer getChargeQuantity() {
		return chargeQuantity;
	}
	public void setChargeQuantity(Integer chargeQuantity) {
		this.chargeQuantity = chargeQuantity;
	}
	public String getDiscountTypeDesc() {
		return discountTypeDesc;
	}
	public void setDiscountTypeDesc(String discountTypeDesc) {
		this.discountTypeDesc = discountTypeDesc;
	}
	public String getProductCodeDesc() {
		return productCodeDesc;
	}
	public void setProductCodeDesc(String productCodeDesc) {
		this.productCodeDesc = productCodeDesc;
	}
    
    
    

}
