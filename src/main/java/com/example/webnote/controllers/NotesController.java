package com.example.webnote.controllers;

import com.example.webnote.config_secure.UserDetailsImpl;
import com.example.webnote.models.Note;
import com.example.webnote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class NotesController {
    @Autowired
    private NoteService noteService;

    @GetMapping("notes")
    public String notes(@AuthenticationPrincipal UserDetailsImpl o,
                        //@ModelAttribute(name = "id") Integer id,
                        ModelMap model) {
        //System.err.println(o);
        UserDetailsImpl details = o;
//        details.user.getId();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.err.println("authentication = " + authentication);
//        System.err.println(authentication.getAuthorities());
//        //
//        for (GrantedAuthority authority : authentication.getAuthorities()) {
//            System.err.println(authority.getAuthority().equals(
//                    User.Role.USER.name()
//            ));
//        }
        List<Note> notes = noteService.findAllByUser_Id(details.user.getId());
        model.put("notes", notes);
        return "notes";
    }

    @PostMapping("noteAdd")
    public String noteAdd(@AuthenticationPrincipal UserDetailsImpl o,
                          @RequestParam String header,
                          @RequestParam String text1,
                          ModelMap modelMap) {
        UserDetailsImpl details = o;
        Note note = new Note(0, LocalDate.now(), header, text1, details.user);
        note = noteService.save(note);
        modelMap.put("note", note);
        //return new ModelAndView("redirect:notes", modelMap);
        return "redirect:notes";
    }
}
