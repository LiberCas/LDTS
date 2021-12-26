import spock.lang.Specification

class test2 extends Specification {

    def "stringDrink test2"() {
        when:
        StringDrink drink = new StringDrink("ABCD");
        then:
        drink.getText() == "ABCD";
        when:
        drink.setText("DCBA");
        then:
        drink.getText() == "DCBA";
    }


    def "stringInverter test2"() {
        given:
        StringDrink drink = new StringDrink("ABCD");
        StringInverter si = new StringInverter();
        when:
        si.execute(drink);
        then:
        drink.getText() == "DCBA";
    }

    def "stringCaseChanger test2"() {
        given:
        StringDrink drink = new StringDrink("aBcD");
        StringCaseChanger cc = new StringCaseChanger();
        when:
        cc.execute(drink);
        then:
        drink.getText() == "AbCd";
    }


    def "stringReplacer test2"() {
        given:
        StringDrink drink = new StringDrink("ABCDABCD");
        StringReplacer sr = new StringReplacer('A' as char, 'X' as char);
        when:
        sr.execute(drink);
        then:
        drink.getText() == "XBCDXBCD";
    }

    def "transformUndo test2"() {
        given:
        StringDrink drink = new StringDrink( "AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A' as char, 'X'as char);
        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);
        when:
        sr.undo(drink);
        then:
        drink.getText()=="dCbA-DcBa";
        when:
        cc.undo(drink);
        then:
        drink.getText()=="DcBa-dCbA";
        when:
        si.undo(drink);
        then:
        drink.getText()=="AbCd-aBcD";
    }

    def "stringRecipe test2"() {
        given:
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A' as char, 'X' as char);
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);
        StringRecipe recipe = new StringRecipe(transformers);
        when:
        recipe.mix(drink);
        then:
        drink.getText() == "dCbX-DcBa";
    }

    def "transformerGroup test2"() {
        given:
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        StringTransformerGroup tg = new StringTransformerGroup(transformers);
        when:
        tg.execute(drink);
        then:
        drink.getText() == "dCbA-DcBa";
    }

    def "transformerComposite test2"() {
        //Treat a group of Transformers as if they were an individual Transformer
        given:
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A' as char, 'X' as char);
        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);
        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);
        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);
        StringRecipe recipe = new StringRecipe(transformers3);
        when:
        recipe.mix(drink);
        then:
        drink.getText() == "DcBx-dCbA";
    }

    def "happyHour test2"() {
        when:
        Bar bar = new StringBar();
        then:
        !bar.isHappyHour();
        when:
        bar.startHappyHour();
        then:
        bar.isHappyHour();
        when:
        bar.endHappyHour();
        then:
        !bar.isHappyHour();
    }


}
