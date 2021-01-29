package group.jkiakumbo.bibleAPI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import group.jkiakumbo.bibleAPI.util.BibleAPIStringUtil;

@Entity
public class Book  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotNull
	private Integer numberOfChapters;
	
	@NotBlank
	private String testament;
	
	@ManyToOne
	@JoinColumn(name = "bible_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@NotNull
	private Bible bible;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Chapter> chapters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = BibleAPIStringUtil.capitalize(name);
	}

	public Integer getNumberOfChapters() {
		return numberOfChapters;
	}

	public void setNumberOfChapters(Integer numberOfChapters) {
		this.numberOfChapters = numberOfChapters;
	}

	public String getTestament() {
		return BibleAPIStringUtil.capitalize(testament);
	}

	public void setTestament(String testament) {
		testament = testament.toLowerCase();
		this.testament = testament;
	}

	public Bible getBible() {
		return bible;
	}

	public void setBible(Bible bible) {
		this.bible = bible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", numberOfChapters=" + numberOfChapters + ", testament="
				+ testament + ", bible=" + bible + "]";
	}
	
	

}
