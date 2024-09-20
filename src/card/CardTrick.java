package card;

import java.util.Scanner;
import java.util.Random;

public class CardTrick 
{
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        // Filling the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) 
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit between 0 and 3
            magicHand[i] = c;
        }
        
        // Asking the user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Pick a suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();
        
        // Creating a card based on user input
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Searching for the user's card in the magic hand
        boolean found = false;
        for (Card card : magicHand) 
        {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) 
            {
                found = true;
                break;
            }
        }
        
        // Report the result
        if (found) 
        {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } 
        else 
        {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        // Hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        // Searching for the lucky card
        boolean luckyFound = false;
        for (Card card : magicHand) 
        {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) 
            {
                luckyFound = true;
                break;
            }
        }
        
        // Reporting the lucky card result
        if (luckyFound) 
        {
            System.out.println("The lucky card (2 of Clubs) is in the magic hand! You win!");
        } 
        else 
        {
            System.out.println("The lucky card (2 of Clubs) is not in the magic hand.");
        }
    }
}