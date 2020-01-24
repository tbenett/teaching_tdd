import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzShould {

  /*
  fizzBuzz
  0 - "0"
  1 - "1"
  2 - "2"
  3 - "Fizz"
  4 - "4"
  5 - "Buzz"
  6 - "Fizz"
   */

  // Test first : j'ecris mon test avant mon code
  //
  // TDD as you mean it:
  //   - déferrer maximum les décisions de design
  //   - faire emerger le comportement d'abord
  //
  // red first: on veut voir un test echouer
  //
  // example based: telle sortie correspond à telle entrée
  //
  // shameless green: faire passer le test au plus vite
  //
  // bad faith: bonne foi dans le test, mauvaise foi dans le code
  //
  // comptabilité à 2 entrées: le test teste le code, le code teste le test
  //
  // ping-pong programming: écrire un test au rouge / passer le clavier pour l'implemn / ...
  //
  // lazy naming: on déferre au maximum le naming des entités
  //
  // make it work, make it right, make it fast: séparation d'inquiétudes
  //
  // on veut avoir des tests par comportement mais avec une seule assertion
  //
  // cartographie d'un problème
  //
  // pourquoi on test:
  //   - show a behavior
  //   - documenter
  //   - guider l'ajout de complexité
  //   - éviter les regressions
  //   - pour raisonner (aide à la compréhension du problème)
  //   - permettre archéologie (découvrir des règles métier dont personne ne souvient)
  //
  // d'example based testing à behavior based testing
  //
  // la mauvaise foi n'a pas de limite
  //
  // règle de trois: on refacto apres 3 duplications de tests
  //
  // l'ordre de lecture de mes tests nest pas necessairement l'ordre decriture
  //
  // IN ENGLISH YOU CAN VERB EVERYTHING

  @ParameterizedTest
  @ValueSource(ints = { 3*5, 2 * 3*5, 8 * 3*5, 4 * 3*5 , 10 * 3*5 })
  void fizzbuzz_on(int a_multiple_of_3_and_5) {
    assertThat(fizzbuzz(a_multiple_of_3_and_5)).isEqualTo("fizzbuzz");
  }

  @ParameterizedTest
  @ValueSource(ints = { 3, 6, 9, 99, 12, 33, 66 })
  void fizz_on(int a_multiple_of_3) {
    assertThat(fizzbuzz(a_multiple_of_3)).isEqualTo("fizz");
  }

  @ParameterizedTest
  @ValueSource(ints = { 5, 20, 125, 10, 25, 35 })
  void buzz_on(int a_multiple_of_5) {
    assertThat(fizzbuzz(a_multiple_of_5)).isEqualTo("buzz");
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 4, 8, 61 })
  void otherwise_echo_its(int input) {
    assertThat(fizzbuzz(input)).isEqualTo(String.valueOf(input));
  }

  private String fizzbuzz(int i) {
    return i == 0 ? "0"
      : isMultipleOf(i, 3 * 5) ? "fizzbuzz"
      : isMultipleOf(i, 3) ? "fizz"
      : isMultipleOf(i, 5) ? "buzz"
      : i + "";
  }

  private boolean isMultipleOf(int i, int i1) {
    return i % i1 == 0;
  }
}
