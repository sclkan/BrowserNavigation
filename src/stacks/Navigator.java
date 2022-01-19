package stacks;

/**
 * @author Sean Kan
 *
 */
public class Navigator
{
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    Navigator()
    {
        currentLink = null;
        backLinks = new StackList<String>("Back");
        forwardLinks = new StackList<String>("Forward");
    }

    public void setCurrentLink(String link)
    {
        if (currentLink != null)
            backLinks.push(currentLink);
        currentLink = link;
        forwardLinks.clear();
    }

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

    public String getCurrentLink()
    {
        return currentLink;

    }

    public StackList<String> getBackLinks()
    {
        return backLinks;
    }

    public StackList<String> getForwardLinks()
    {
        return forwardLinks;
    }
}