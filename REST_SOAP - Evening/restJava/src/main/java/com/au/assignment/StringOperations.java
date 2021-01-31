package com.au.assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/stringoperations")
public class StringOperations {
	
	@GetMapping("")
	public String home() {

		return "Home Page <hr>"
		+ "GET: <br>"
		+ "/concatenation/{firstName}/{lastName}       <br>"
		+ "/split?firstName=_&lastName=_               <br>"
		+ "/findsubstring?text=_&str=_                 <hr>" 
		+ "POST:	                                   <br>"
		+ "/findsubstring?text=_&str=_                 <br>"
		+ "/multiplyString?String=_&Number=_           ";	
		
	}
	
	@GetMapping("/concatenation/{firstName}/{lastName}")
	public String generate(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return firstName+ " " + lastName;
	}
	
	@GetMapping("/split")
	public String split(@RequestParam("string1") String string1, @RequestParam("string2") String string2) {
		
		return string1.split(string2)[0];
	}
	
	@GetMapping("/findsubstring")
	public int findSubstring(@RequestParam("text") String text,@RequestParam("str") String str) {

        int index = 0, count = 0;
        while (true) {
            index = text.indexOf(str, index);
            if (index != -1) {
                count ++;
                index += str.length();
            } else {
                break;
            }
        }
 
        return count;
	}
	
	@PostMapping("/findsubstring")
	public String findSubstringPut(@RequestParam("text") String text,@RequestParam("str") String str) {
		
        int index = 0, count = 0;
        while (true) {
            index = text.indexOf(str, index);
            if (index != -1) {
                count ++;
                index += str.length();
            } else {
                break;
            }
        }
 
        return "From the post method " + count;
	}
	
	@PostMapping("/multiplyString")
	public String multiplyString(@RequestParam("String") String string, @RequestParam("Number") int number) {
		return string.repeat(number);
	}

}
