package com.revature.models;

public class Transaction {
	
	private Integer id;
	private Integer fromAcc;
	private Integer toAcc;
	private Double amount;
	private String type;
	private String status;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer id, Integer fromAcc, Integer toAcc, Double amount, String type, String status) {
		super();
		this.id = id;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.type = type;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(Integer fromAcc) {
		this.fromAcc = fromAcc;
	}

	public Integer getToAcc() {
		return toAcc;
	}

	public void setToAcc(Integer toAcc) {
		this.toAcc = toAcc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((fromAcc == null) ? 0 : fromAcc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toAcc == null) ? 0 : toAcc.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (fromAcc == null) {
			if (other.fromAcc != null)
				return false;
		} else if (!fromAcc.equals(other.fromAcc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toAcc == null) {
			if (other.toAcc != null)
				return false;
		} else if (!toAcc.equals(other.toAcc))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", amount=" + amount + ", type="
				+ type + ", status=" + status + "]";
	}
	
	
	
	
	
}
