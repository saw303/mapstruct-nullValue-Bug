package ch.silviowangler.mapstruct;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author Silvio Wangler
 */
@MapperConfig(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public class MappingConfig {
}
