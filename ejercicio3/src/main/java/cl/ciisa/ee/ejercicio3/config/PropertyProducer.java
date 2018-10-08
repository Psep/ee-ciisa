package cl.ciisa.ee.ejercicio3.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class PropertyProducer {

	private Properties properties;

	@Property
	@Produces
	public String produceString(final InjectionPoint point) {
		return this.properties.getProperty(this.getKey(point));
	}

	private String getKey(final InjectionPoint point) {
		return (point.getAnnotated().isAnnotationPresent(Property.class)
				&& !point.getAnnotated().getAnnotation(Property.class).value().isEmpty())
						? point.getAnnotated().getAnnotation(Property.class).value()
						: point.getMember().getName();
	}

	@PostConstruct
	public void init() {
		this.properties = new Properties();
		final InputStream stream = PropertyProducer.class.getResourceAsStream("/dao.properties");

		if (stream == null) {
			throw new RuntimeException("Properties file not found!");
		}

		try {
			this.properties.load(stream);
		} catch (final IOException e) {
			throw new RuntimeException("Configuration could not be loaded!");
		}

	}

}
