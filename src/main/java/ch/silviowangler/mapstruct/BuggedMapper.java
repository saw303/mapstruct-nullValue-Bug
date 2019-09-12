package ch.silviowangler.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author Silvio Wangler
 */
@Mapper(
        config = MappingConfig.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BuggedMapper {

    CarDto toCarDto(CarModel carModel);

    // remove this annotation to trigger the bug described in https://github.com/mapstruct/mapstruct/issues/1790
    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toExistingCar(@MappingTarget CarDto carDto, CarModel carModel);

    void toExistingCarWithBug(@MappingTarget CarDto carDto, CarModel carModel);
}
