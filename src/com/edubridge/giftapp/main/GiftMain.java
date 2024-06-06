package com.edubridge.giftapp.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.giftapp.model.Gift;
import com.edubridge.giftapp.service.GiftService;
import com.edubridge.giftapp.service.GiftServiceImpl;


public class GiftMain {
public static void main(String[] args) {
		
		 GiftService service = new GiftServiceImpl();
		
		  Gift gift= null;
		
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("  ");
			System.out.println("***WELCOME TO GIFT APP***");
			System.out.println("*************************\n");
			System.out.println("==> 1. Add Gift Record");
			System.out.println("==> 2. View All Gifts");
			System.out.println("==> 3. Update Gift");
			System.out.println("==> 4. Delete One Gift");
			System.out.println("==> 5. Delete All Gifts");
			System.out.println("==> 6. Search Gift By Name");
			System.out.println("==> 0. Exit\n");
			System.out.println("***PLEASE CHOOSE THE CORRECT OPTION***");
			option = in.nextInt();
			switch(option) {
			case 1:
				System.out.println("ADD NEW GIFT");
				System.out.println("----------------");
				System.out.println("Please Enter Gift Name");
				String name=in.next();
				System.out.println("Please Enter Gift Price");
				double price = in.nextDouble();
				System.out.println("Please Enter Gift Occasion");
				String occasion=in.next();
				System.out.println("Please Enter Gift Rating[1-10]");
				float rating=in.nextFloat();
				gift=new Gift();
				gift.setName(name);
				gift.setPrice(price);
				gift.setOccasion(occasion);
				gift.setRating(rating);
				
				int status = service.addGift(gift);
				if(status==1) {
					System.out.println("New Gift Added!");
				}else {
					System.out.println("Something Is Wrong");
				}
				
				
				break;
			case 2:
				
				List<Gift> gifts= service.findGifts();
				System.out.println("View Gifts");
				for(Gift gift1:gifts) {
					System.out.println("Gift ID       : "+gift1.getId());
					System.out.println("Gift Name     : "+gift1.getName());
					System.out.println("Gift Price    : "+gift1.getPrice());
					System.out.println("Gift Occasion : "+gift1.getOccasion());
					System.out.println("Gift Rating   : "+gift1.getRating());
				}
				break;
			case 6:
				System.out.println("Search Gift BY Name");
				System.out.println("Please Enter Gift name");
				name=in.next();
				
				gift = service.findGiftByName(name);
				 
				if (gift != null) {
					// g = gs.findGiftByName(name);
			        System.out.println("Gift Found:--------------------");
			        System.out.println("Gift ID       : "+gift.getId());
					System.out.println("Gift Name     : "+gift.getName());
					System.out.println("Gift Price    : "+gift.getPrice());
					System.out.println("Gift Occasion : "+gift.getOccasion());
					System.out.println("Gift Rating   : "+gift.getRating());
			       // System.out.println(g.getId()+"\t"+ g.getName()+"\t"+g.getPrice()+"\t"+g.getOccasion()+"\t"+ g.getRating());
		
			    } else {
			        System.out.println("Gift Not Found.");
			    }
				break;
			case 3:
				System.out.println("Update Contact");
				System.out.println("---------------");
				System.out.println("Search Gift BY Name");
				System.out.println("Please Enter Gift Name");
				name=in.next();
				
				gift = service.findGiftByName(name);
				 
				if (gift != null) {
					// g = gs.findGiftByName(name);
			        System.out.println("Gift Found:");
			        System.out.println("Gift ID       : "+gift.getId());
					System.out.println("Gift Name     : "+gift.getName());
					System.out.println("Gift Price    : "+gift.getPrice());
					System.out.println("Gift Occasion : "+gift.getOccasion());
					System.out.println("Gift Rating   : "+gift.getRating());
			     
				System.out.println("Please Enter Updating Gift Name");
				name=in.next();
				System.out.println("Please Enter Updating Occation");
				occasion=in.next();
				System.out.println("Please Enter Updating Gift Price");
				price=in.nextDouble();
				System.out.println("Please Enter Updating Gift Rating");
				rating=in.nextFloat();
				System.out.println("Plzz Enter Existed Id");
				int id = in.nextInt();
				
				gift=new Gift();
				gift.setName(name);
				gift.setOccasion(occasion);
				gift.setPrice(price);
				gift.setRating(rating);
				gift.setId(id);
				
				status =service.updateGift(gift);
				if(status==1) {
					System.out.println("Updated Succesfully");
				}else {
					System.out.println("SomeThing is Wrong Added");
				}
				}else {
					System.out.println("No Contact Found With Name");
				}
				
				break;
			case 4:
				System.out.println("Delete Gift");
				System.out.println("Please Enter Gift Name");
				name=in.next();
				//g=new Gift();
				status=service.deleteGiftByName(name);
				if(status == 1) {
					System.out.println("DELETED GIFT");
				}else {
					System.out.println("Something  Wrong");
				}
				
				break;
			case 5:
				//System.out.println("Delete All Contact");
				System.out.println("Are Uh Sure delete all Gifts[Y/N]");
				String deleteConformStatus=in.next();
				
				if(deleteConformStatus.equalsIgnoreCase("Y")) {
				   service.deleteAllGifts();
				   System.out.println("All Gifts are Deleted");
				}
				
				
				break;
			case 0:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Option");
					break;
			
			}
			
		}while(option!=0);
	}

}
