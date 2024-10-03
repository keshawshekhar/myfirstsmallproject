package com.project.dto;

public class DashboardDTO {

	private long total_enq;
	private long open_enq;
	private long enroll_enq;
	private long loss_enq;
	
	
	public DashboardDTO(long total_enq, long open_enq, long enroll_enq, long loss_enq) {
		super();
		this.total_enq = total_enq;
		this.open_enq = open_enq;
		this.enroll_enq = enroll_enq;
		this.loss_enq = loss_enq;
	}


	public long getTotal_enq() {
		return total_enq;
	}
	
	
	public void setTotal_enq(long total_enq) {
		this.total_enq = total_enq;
	}
	public long getOpen_enq() {
		return open_enq;
	}
	public void setOpen_enq(long open_enq) {
		this.open_enq = open_enq;
	}
	public long getEnroll_enq() {
		return enroll_enq;
	}
	public void setEnroll_enq(long enroll_enq) {
		this.enroll_enq = enroll_enq;
	}
	public long getLoss_enq() {
		return loss_enq;
	}
	public void setLoss_enq(long loss_enq) {
		this.loss_enq = loss_enq;
	}
	
	
	
	
	
	
}
