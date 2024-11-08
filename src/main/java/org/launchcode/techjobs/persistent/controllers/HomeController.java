package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    //It doesn't SAY we need this but...?
    @Autowired
    private SkillRepository skillRepository;

    @Autowired //IS THIS NEEDED?
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        //DO DATA HERE??
        model.addAttribute("employers", employerRepository.findAll());

        //TODO FIGURE OUT IF THIS IS CORRECT
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    //TODO MAKE SURE THIS ALL WORKS
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");

            //THIS HERE FOR WWRONG STUFF IN MAKING JOB?
            model.addAttribute("employers", employerRepository.findAll());
            return "add";
        }

        //employerRepository.save(newJob);

        model.addAttribute("employer", employerRepository.findById(employerId));
        model.addAttribute("job", newJob);

        //IS THIS WHAT'S WRONG???
        model.addAttribute("skills", skills);
        //model.addAttribute("skills", skillRepository.findAllById(skills));

        //IS THIS EVEN WHAT I'm SUPPOSED TO BE DOING WITH THIS???
        Optional<Employer> result = employerRepository.findById(employerId);

        //TODO FIGURE OUT IF THIS CHECK WILL LET ME PASS TEST
        if(result.isPresent()) {
            Employer newJobEmployer = result.get();
            newJob.setEmployer(newJobEmployer);
        }

//        Employer result =  employerRepository.findById(employerId);
//        Employer newJobEmployer = result.get();
//        newJob.setEmployer(result);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);



        //newJob.setEmployer(employerRepository.findById(employerId));


        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        //Didn't TELL us to do this but...
        Optional optJob = jobRepository.findById(jobId);
        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
            model.addAttribute("job", job);
            return "/view";
        } else {
            return "redirect:../";
            //return "view";
        }
    }

}
