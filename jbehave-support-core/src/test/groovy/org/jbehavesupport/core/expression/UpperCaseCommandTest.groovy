package org.jbehavesupport.core.expression


import org.jbehavesupport.core.internal.expression.UpperCaseCommand
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

@Unroll
class UpperCaseCommandTest extends Specification {

    def "test execute with #expression returns #expected"() {
        when:
        def actual = new UpperCaseCommand().execute(*expression)
        then:
        expected == actual
        where:
        expression || expected
        ["Test"]   || "TEST"
    }

    def "test execute with #expression throws #expected"() {
        when:
        new UpperCaseCommand().execute(*expression)
        then:
        Exception exception = thrown()
        expected == exception.class
        where:
        expression          || expected
        []                  || IllegalArgumentException.class
        ["a", "1"]          || IllegalArgumentException.class
        [LocalDate.now()]   || IllegalArgumentException.class
    }

}
