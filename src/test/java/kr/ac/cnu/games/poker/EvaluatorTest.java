package kr.ac.cnu.games.poker;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by rokim on 2017. 6. 4..
 */
public class EvaluatorTest {
    private Evaluator evaluator;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
    }

    // <!-- High CARD 테스트

    @Test
    public void evaluateHighCard1() {
        List<Hands> handsList = new ArrayList<>();
        handsList.add(getStright());
        handsList.add(getFlush());

        List<Hands> resultList = evaluator.evalauteHighHands(handsList);

        assertThat(resultList.get(0).getHandsType(), is(HandsType.FLUSH));
        assertThat(resultList.get(1).getHandsType(), is(HandsType.STRIGHT));
    }

    @Test
    public void evaluateHighCard2() {
        List<Hands> handsList = new ArrayList<>();
        handsList.add(getStright());
        handsList.add(getOnepair());
        handsList.add(getNothing());
        handsList.add(getFlush());
        handsList.add(getFullhouse());
        handsList.add(getTwopair());

        List<Hands> resultList = evaluator.evalauteHighHands(handsList);

        System.out.println(handsList);

        assertThat(resultList.get(0).getHandsType(), is(HandsType.FULL_HOUSE));
        assertThat(resultList.get(1).getHandsType(), is(HandsType.FLUSH));
        assertThat(resultList.get(2).getHandsType(), is(HandsType.STRIGHT));
        assertThat(resultList.get(3).getHandsType(), is(HandsType.TWO_PAIR));
        assertThat(resultList.get(4).getHandsType(), is(HandsType.ONE_PAIR));
        assertThat(resultList.get(5).getHandsType(), is(HandsType.NOTHING));
    }

    // TODO 각 HandsType 에 맞춰 ordering 이 잘 되는지 확인
    // TODO HandsType 이 같을때 가장 높은 숫자로 odering 이 되는지 확인.


    // High CARD 테스트 -->


@Ignore
    // <!-- Low CARD 테스트
    @Test
    public void evaluateLowCard1() {
        List<Hands> handsList = new ArrayList<>();
        handsList.add(getStright());
        handsList.add(getFlush());

        List<Hands> resultList = evaluator.evalauteLowHands(handsList);
        System.out.print(handsList);
        assertThat(resultList.get(0).getHandsType(), is(HandsType.STRIGHT));
        assertThat(resultList.get(1).getHandsType(), is(HandsType.FLUSH));

    }

    // TODO 각 HandsType 에 맞춰 ordering 이 잘 되는지 확인
    // TODO HandsType 이 같을때 가장 낮은 숫자로 odering 이 되는지 확인.

    // Low CARD 테스트 -->


    // Givens
    private Hands getFlush() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(2, Suit.CLUBS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(6, Suit.CLUBS));
        cardList.add(new Card(7, Suit.CLUBS));

        return new Hands(HandsType.FLUSH, cardList);
    }

    private Hands getStright() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(2, Suit.DIAMONDS));
        cardList.add(new Card(5, Suit.CLUBS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(4, Suit.CLUBS));

        return new Hands(HandsType.STRIGHT, cardList);
    }
    private Hands getOnepair() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(9, Suit.SPADES));

        return new Hands(HandsType.ONE_PAIR, cardList);
    }

    private Hands getNothing() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(9, Suit.SPADES));

        return new Hands(HandsType.NOTHING, cardList);
    }
    private Hands getTwopair() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(9, Suit.SPADES));

        return new Hands(HandsType.TWO_PAIR, cardList);
    }
    private Hands getFullhouse() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(1, Suit.CLUBS));
        cardList.add(new Card(5, Suit.DIAMONDS));
        cardList.add(new Card(1, Suit.HEARTS));
        cardList.add(new Card(3, Suit.HEARTS));
        cardList.add(new Card(9, Suit.SPADES));

        return new Hands(HandsType.FULL_HOUSE, cardList);
    }
}
