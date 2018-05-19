/* 638.Shopping Offers
 * Thought Process:
State : $x for _A 
 * GET:
 *  start : needs
    standing at curNeeds, we can pick any one of offer, if no offer availale, we do not pick offer
    end   : needs clear  
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int withOffer = shoppingOffersWithNeedsEqualTo(price, special, needs, new HashMap<>());
        int withoutOffer = getPriceWithoutOffer(price, needs);
        return Math.min(withOffer, withoutOffer);
    }

    private int shoppingOffersWithNeedsEqualTo(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> visitedNeeds) {
        if (visitedNeeds.containsKey(needs.toString())) {
            return visitedNeeds.get(needs.toString());
        }
        int lowestPrice = Integer.MAX_VALUE;
        for (List<Integer> offer : special) {
            List<Integer> curNeeds = reduceNeeds(needs, offer);
            if (curNeeds == null) {
                continue;
            }
            lowestPrice = Math.min(lowestPrice, offer.get(offer.size() - 1) + shoppingOffersWithNeedsEqualTo(price, special, curNeeds, visitedNeeds));
        }
        // if no valid offer
        if (lowestPrice == Integer.MAX_VALUE) {
            lowestPrice = getPriceWithoutOffer(price, needs);
        }
        visitedNeeds.put(needs.toString(), lowestPrice);
        return lowestPrice;
    }

    private List<Integer> reduceNeeds(List<Integer> needs, List<Integer> special) {
        List<Integer> curNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return null;
            }
            curNeeds.add(needs.get(i) - special.get(i));
        }
        return curNeeds;
    }

    private int getPriceWithoutOffer(List<Integer> price, List<Integer> needs) {
        int withoutOffer = 0;
        for (int i = 0; i < needs.size(); i++) {
            withoutOffer += needs.get(i) * price.get(i);
        }
        return withoutOffer;
    }
}
