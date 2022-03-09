/**
 * Class: CMSC203 
 *  Program: Assignment #3
 *  Instructor: Dr. Ahmed Tarek
 * Description: (Give a brief description for each Program)
  this program encrypts and decrypts strings using two different methods 
 * Due: MM/DD/YYYY (<03/9/2022>)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Giovanni Argueta
*/

public class CryptoManager {
  
static int LOWER_BOUND=32;
static int UPPER_BOUND=95;
  
/**
 * This method determines if a string is within the allowable bounds of ASCII codes 
 * according to the LOWER_BOUND and UPPER_BOUND characters
 * @param plainText a string to be encrypted, if it is within the allowable bounds
 * @return true if all characters are within the allowable bounds, false if any character is outside
 */
public static boolean stringInBounds (String plainText)
{
boolean flag=true;

for(int i=0;i<plainText.length();i++)
{
if(!((int)plainText.charAt(i)>=LOWER_BOUND && (int)plainText.charAt(i)<=UPPER_BOUND))
{ 
flag=false;
break;
}
}

return flag;
}

/**
 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
 * and each character in plainText is replaced by the character \"offset\" away from it 
 * @param plainText an uppercase string to be encrypted.
 * @param key an integer that specifies the offset of each character
 * @return the encrypted string
 */

public static String encryptCaesar(String plainText, int key)
{

key=Wrap_around(key);

//encrypted text
String encrypted="";

for(int i=0;i<plainText.length();i++)
{
	encrypted+=Character.toString((char) ((int)plainText.charAt(i)+key));
}

return encrypted;
}
/**
 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
 * This is the inverse of the encryptCaesar method.
 * @param encryptedText an encrypted string to be decrypted.
 * @param key an integer that specifies the offset of each character
 * @return the plain text string
 */
public static String decryptCaesar(String encryptedText, int key){

key=Wrap_around(key);
String org="";
for(int i=0;i<encryptedText.length();i++)
{
org+=Character.toString((char) ((int)encryptedText.charAt(i)-key));
}

return org;
}
  
public static int Wrap_around(int key)
{
while(key>UPPER_BOUND)
{
key-=(UPPER_BOUND-LOWER_BOUND);
}
return key;
}
/**
 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
 * to correspond to the length of plainText
 * @param plainText an uppercase string to be encrypted.
 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
 * @return the encrypted string
 */
public static String encryptBellaso(String plainText, String bellasoStr)
{   
//encrypted text
String encrypted="";

while(bellasoStr.length()<plainText.length())
{
bellasoStr+=bellasoStr.substring(0,(plainText.length()-bellasoStr.length()));
}
  
//encryption
for(int i=0;i<plainText.length();i++)
{
char c=(char)Wrap_around((int)plainText.charAt(i)+(int)bellasoStr.charAt(i) );
encrypted+=Character.toString(c);
}
return encrypted;
}

/**
 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
 * the character corresponding to the character in bellasoStr, which is repeated
 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
 * @param encryptedText an uppercase string to be encrypted.
 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
 * @return the decrypted string
 */
public static String decryptBellaso(String encryptedText, String bellasoStr)
{

String encrypted="";


while(bellasoStr.length()<encryptedText.length())
{
bellasoStr+=bellasoStr.substring(0,(encryptedText.length()-bellasoStr.length()));
}
  

for(int i=0;i<encryptedText.length();i++)
{
char c=(char)Wrap_around((int)encryptedText.charAt(i)-(int)bellasoStr.charAt(i) );
encrypted+=Character.toString(c);
}

return encrypted;
}



}
