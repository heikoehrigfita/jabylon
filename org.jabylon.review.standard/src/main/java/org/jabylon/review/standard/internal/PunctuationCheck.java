/**
 *
 */
package org.jabylon.review.standard.internal;

import java.text.MessageFormat;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import org.jabylon.common.review.ReviewParticipant;
import org.jabylon.properties.PropertiesFactory;
import org.jabylon.properties.Property;
import org.jabylon.properties.PropertyFileDescriptor;
import org.jabylon.properties.Review;
import org.jabylon.properties.Severity;

/**
 * @author Johannes Utzig (jutzig.dev@googlemail.com)
 *
 */
@Component
@Service
public class PunctuationCheck implements ReviewParticipant {


    private static char[] hotchars = {'(',')','[',']','{','}','\'','"'};

    /* (non-Javadoc)
     * @see org.jabylon.common.review.ReviewParticipant#review(org.jabylon.properties.PropertyFileDescriptor, org.jabylon.properties.Property, org.jabylon.properties.Property)
     */
    @Override
    public Review review(PropertyFileDescriptor descriptor, Property master, Property slave) {
        if(master==null||slave==null||slave.getValue()==null||slave.getValue().isEmpty())
            return null;

        short[] templateOccurrences = new short[hotchars.length];
        String value = master.getValue();
        String translation = slave.getValue();
        countHotChars(value,templateOccurrences);
        subtractHotChars(translation,templateOccurrences);
        for(int i = 0;i<hotchars.length;i++)
        {
            int occ = templateOccurrences[i];
            if(occ!=0)
            {
                Review review = PropertiesFactory.eINSTANCE.createReview();
                review.setCreated(System.currentTimeMillis());
                String message;
                if(occ<0)
                    message = "Translation contains more ''{0}'' characters than the template.";
                else
                    message = "Translation contains less ''{0}'' characters than the template.";
                message = MessageFormat.format(message, hotchars[i]);
                review.setMessage(message);
                review.setReviewType("Punctuation Check");
                review.setSeverity(Severity.WARNING);
                review.setUser("Jabylon");
                return review;
            }
        }
        return null;


    }

    private void countHotChars(String value, short[] templateOccurrences) {
        if(value==null)
            return;
        char[] chars = value.toCharArray();
        for (char c : chars) {
            switch (c) {
            case '(':
                templateOccurrences[0]++;
                break;
            case ')':
                templateOccurrences[1]++;
                break;
            case '[':
                templateOccurrences[2]++;
                break;
            case ']':
                templateOccurrences[3]++;
                break;
            case '{':
                templateOccurrences[4]++;
                break;
            case '}':
                templateOccurrences[5]++;
                break;
            case '"':
                templateOccurrences[6]++;
                break;

            default:
                break;
            }
        }

    }

    private void subtractHotChars(String value, short[] templateOccurrences) {
        if(value==null)
            return;
        char[] chars = value.toCharArray();
        for (char c : chars) {
            switch (c) {
            case '(':
                templateOccurrences[0]--;
                break;
            case ')':
                templateOccurrences[1]--;
                break;
            case '[':
                templateOccurrences[2]--;
                break;
            case ']':
                templateOccurrences[3]--;
                break;
            case '{':
                templateOccurrences[4]--;
                break;
            case '}':
                templateOccurrences[5]--;
                break;
            case '"':
                templateOccurrences[6]--;
                break;

            default:
                break;
            }
        }

    }

    @Override
    public String getID() {
        return getClass().getSimpleName();
    }

    @Override
    public String getDescription() {
        return "Checks if the punctuation between template and translation is consitent (brackets, braces, quotes, double quotes, parenthesis,..)";
    }

    @Override
    public String getName() {
        return "Punctuation Check";
    }

}