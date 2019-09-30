package ch.silviowangler.mapstruct

import spock.lang.Issue
import spock.lang.PendingFeature
import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Silvio Wangler
 */
class BuggedMapperSpec extends Specification {

    @Subject
    BuggedMapper mapper = new BuggedMapperImpl()

    void "Null value should not be mapped"() {

        given:
        CarDto target = new CarDto(name: "My name is set")

        and:
        CarModel source = new CarModel(name: null)

        when:
        mapper.toExistingCar(target, source)

        then: 'the name has not been overwritten since the source value is null'
        target.name == "My name is set"
    }

    //@PendingFeature(reason = "Mapstruct 1.3.0.Final & 1.3.1.Final contains a bug")
    @Issue("https://github.com/mapstruct/mapstruct/issues/1790")
    void "Null value should not be mapped (Bug)"() {

        given:
        CarDto target = new CarDto(name: "My name is set")

        and:
        CarModel source = new CarModel(name: null)

        when:
        mapper.toExistingCarWithBug(target, source)

        then: 'the name has not been overwritten since the source value is null'
        target.name == "My name is set"
    }
}
