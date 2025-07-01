package com.boletos.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "boletos")
public class Boletos {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    @Column(name = "id")
	    private Long id;
	    @Column(name = "usuario_id")
	    private Integer usuario;
	    @Column(name = "funcion_id")
	    private Integer funcion;
	    @Column(name = "cantidad")
	    private Integer cantidad;
	    @Column(name = "total")
	    private Double total;
	    @Column(name = "metodo_pago_id")
	    private Integer metodoP;
		@Column(name = "fecha_compra")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date fecha;
		
		public Boletos() {
			super();
		}

		public Boletos(Long id, Integer usuario, Integer funcion, Integer cantidad, Double total, Integer metodoP,
				Date fecha) {
			super();
			this.id = id;
			this.usuario = usuario;
			this.funcion = funcion;
			this.cantidad = cantidad;
			this.total = total;
			this.metodoP = metodoP;
			this.fecha = fecha;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getUsuario() {
			return usuario;
		}

		public void setUsuario(Integer usuario) {
			this.usuario = usuario;
		}

		public Integer getFuncion() {
			return funcion;
		}

		public void setFuncion(Integer funcion) {
			this.funcion = funcion;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public Integer getMetodoP() {
			return metodoP;
		}

		public void setMetodoP(Integer metodoP) {
			this.metodoP = metodoP;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		@Override
		public String toString() {
			return "Boletos [id=" + id + ", usuario=" + usuario + ", funcion=" + funcion + ", cantidad=" + cantidad
					+ ", total=" + total + ", metodoP=" + metodoP + "]";
		}
		
		
}
