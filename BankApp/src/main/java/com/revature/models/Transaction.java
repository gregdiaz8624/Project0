package com.revature.models;

public class Transaction {
	
	private Integer id;
	private Account transFrom;
	private Account transTo;
	private Double amount;
	private String status;
	
	public Transaction() {
		super();
	
	}

	public Transaction(Integer id, Account transFrom, Account transTo, Double amount, String status) {
		super();
		this.id = id;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.amount = amount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getTransFrom() {
		return transFrom;
	}

	public void setTransFrom(Account transFrom) {
		this.transFrom = transFrom;
	}

	public Account getTransTo() {
		return transTo;
	}

	public void setTransTo(Account transTo) {
		this.transTo = transTo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((transFrom == null) ? 0 : transFrom.hashCode());
		result = prime * result + ((transTo == null) ? 0 : transTo.hashCode());
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
		if (transFrom == null) {
			if (other.transFrom != null)
				return false;
		} else if (!transFrom.equals(other.transFrom))
			return false;
		if (transTo == null) {
			if (other.transTo != null)
				return false;
		} else if (!transTo.equals(other.transTo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transFrom=" + transFrom + ", transTo=" + transTo + ", amount=" + amount
				+ ", status=" + status + "]";
	}

	
	
}
