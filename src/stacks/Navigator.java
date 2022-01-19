package stacks;

/**
 * Class that provides navigation features for BrowserNavigation
 * @author Sean Kan
 *
 */
public class Navigator
{
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    /**
     * Constructor that sets currentLink to null and creates backLinks and forwardLinks objects
     */
    Navigator()
    {
        currentLink = null;
        backLinks = new StackList<String>("Back");
        forwardLinks = new StackList<String>("Forward");
    }

    /**
     * Sets input as current link and updates the backLInks and forwardLinks stacks appropriately
     * @param link   Current requested link
     */
    public void setCurrentLink(String link)
    {
        if (currentLink != null)
            backLinks.push(currentLink);
        currentLink = link;
        forwardLinks.clear();
    }

    /**
     * Goes one page back and displays an error message if backLinks is empty
     */
    public void goBack()
    {
        if (backLinks.isEmpty())
            System.out.print("\nCAN'T GO BACK ANY FURTHER");
        else
        {
            forwardLinks.push(currentLink);
            currentLink = backLinks.pop();
        }
    }

    /**
     * Goes one page forward and displays an error message if forwardLinks is empty
     */
    public void goForward()
    {
        if (forwardLinks.isEmpty())
            System.out.print("\nCAN'T GO ANY FURTHER");
        else
        {
            backLinks.push(currentLink);
            currentLink = forwardLinks.pop();
        }
    }

    /**
     * Accessor method that returns the currentLink
     * @return   The currentLink
     */
    public String getCurrentLink()
    {
        return currentLink;
    }

    /**
     * Accessor method that returns the backLinks
     * @return   The backLinks stack
     */
    public StackList<String> getBackLinks()
    {
        return backLinks;
    }

    /**
     * Accessor method that returns forwardLinks
     * @return   The forwardLinks stack
     */
    public StackList<String> getForwardLinks()
    {
        return forwardLinks;
    }
}