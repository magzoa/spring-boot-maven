package py.edu.facitec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@Table(name = "comentarios")

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Comentario extends General {
	
	
	@Column(name="comentario_texto")
	private String texto;
	
	@Column(name = "comentario_estrella")
	private Integer estrella;
	
	
	@ManyToOne
	private Suscrito suscrito;
	
	@ManyToOne
	private Post post;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getEstrella() {
		return estrella;
	}

	public void setEstrella(Integer estrella) {
		this.estrella = estrella;
	}

	public Suscrito getSuscrito() {
		return suscrito;
	}

	public void setSuscrito(Suscrito suscrito) {
		this.suscrito = suscrito;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
	

}
