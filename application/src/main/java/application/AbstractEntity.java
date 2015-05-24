/**
 * 
 */
package application;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * {@link AbstractEntity} ist die abstrakte Basisklasse für alle ILST-Entitäten.
 * 
 * @author Mark Bretfeld
 * 
 */
@MappedSuperclass
@Entity
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Die Id einer jeden Entity */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

}
