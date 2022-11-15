package com.groupC.twitter.controller;

import com.groupC.twitter.dto.BookmarkDto;
import com.groupC.twitter.dto.UserDto;
import com.groupC.twitter.repository.NotificationRepository;
import com.groupC.twitter.service.NotificationService;
import com.groupC.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService;
    @PostMapping("")
    public ResponseEntity signup(@RequestBody UserDto user){
        return new ResponseEntity(userService.addUser(user), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity updateUser(@RequestBody UserDto userDto){
       return new ResponseEntity(userService.updateUser(userDto),HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity userDetails(@PathVariable("userId") long userId){
        return new ResponseEntity(userService.getUser(userId),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity allUsers(){
        return new ResponseEntity(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity getUserByUsername(@PathVariable("userName") String userName){
        return new ResponseEntity(userService.getUserByUserName(userName),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long userId){
        userService.deleteUser(userId);
        return new ResponseEntity("User Deleted Success Fully",HttpStatus.OK);
    }

    @PutMapping("/follow/{userId}/{followerId}")
    public ResponseEntity addFollower(@PathVariable("userId") long userId, @PathVariable("followerId") long followerId) {
        return new ResponseEntity(userService.addFollower(followerId,userId),HttpStatus.OK);
    }

    @DeleteMapping("/follow/{userId}/{followerId}")
    public ResponseEntity removeFollower(
            @PathVariable("userId") long userId, @PathVariable("followerId") long followerId) {
        return new ResponseEntity(userService.removeFollower(followerId,userId),HttpStatus.OK);
    }
    @DeleteMapping("/following/{userId}/{followingId}")
    public ResponseEntity removeFollowing(@PathVariable("userId") long userId,@PathVariable("followingId") long followingId){
        return new ResponseEntity(userService.deleteFollowing(userId,followingId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers")
    public ResponseEntity getFollowers(@PathVariable("userId") long userId) {
        return new ResponseEntity(userService.getFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followings")
    public ResponseEntity getFollowings(@PathVariable("userId") long userId) {
        return new ResponseEntity(userService.getFollowings(userId),HttpStatus.OK);
    }

    @PostMapping("/following/{userId}/{followingId}")
    public ResponseEntity addFollowing(@PathVariable("userId") long userId,@PathVariable("followingId") long followingId){
        return new ResponseEntity(userService.addFollowing(userId,followingId),HttpStatus.OK);
    }
    @PostMapping("/bookmark")
    public ResponseEntity setBookmark(@RequestBody BookmarkDto bookmark){
        return new ResponseEntity(userService.addBookmark(bookmark),HttpStatus.OK);
    }
    @GetMapping("/bookmark/{userId}")
    public ResponseEntity getBookmark(@PathVariable("userId") long userId){
        return new ResponseEntity(userService.getBookmarks(userId),HttpStatus.OK);
    }
    @PutMapping("/bluetick/{userId}")
    public ResponseEntity requestBluetick(@PathVariable("userId") long userId){
        userService.requestBluetick(userId);
        return new ResponseEntity("Blue tick requested",HttpStatus.OK);
    }
    @GetMapping("/bluetick")
    public ResponseEntity bluetickRequest(){
        return new ResponseEntity(userService.getRequestBluetick(),HttpStatus.OK);
    }
    @PutMapping("/bluetick")
    public ResponseEntity bluetick(@PathVariable("userId") long userId){
        return new ResponseEntity(userService.setBluetick(userId),HttpStatus.OK);
    }
    @GetMapping("/notification/{userId}")
    public ResponseEntity notification(@PathVariable("userId") long userId){
        return new ResponseEntity(notificationService.getNotification(userId),HttpStatus.OK);
    }
}
