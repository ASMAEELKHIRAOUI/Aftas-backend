package com.example.aftas.web.controller;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import com.example.aftas.dto.requests.RegisterMemberRequestDTO;
import com.example.aftas.dto.responses.RankingResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ranking")
public class RankingController {

    private final RankingService rankingService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Ranking> rankings = rankingService.getAll();
        if (rankings.isEmpty()) return ResponseMessage.notFound("No ranking was found");
        else return ResponseMessage.ok("Rankings fetched successfully", rankings.stream().map(RankingResponseDTO::fromRanking).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRankingById(@PathVariable RankId id){
        Ranking ranking = rankingService.getById(id);
        if(ranking == null) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", RankingResponseDTO.fromRanking(ranking));
    }

    @GetMapping("member/{member}")
    public ResponseEntity getRankingByMember(@PathVariable Integer member){
        List<Ranking> rankings = rankingService.getByMember(member);
        if(rankings.isEmpty()) return ResponseMessage.notFound("No ranking was found");
        else return ResponseMessage.ok("Success", rankings.stream().map(RankingResponseDTO::fromRanking).toList());
    }

    @GetMapping("competition/{competition}")
    public ResponseEntity getRankingByCompetition(@PathVariable String competition){
        List<Ranking> rankings = rankingService.sortParticipantsByScore(competition);
        if(rankings.isEmpty()) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", rankings.stream().map(RankingResponseDTO::fromRanking).toList());
    }

    @GetMapping("member_and_competition/{member}/{competition}")
    public ResponseEntity getRankingByMemberAndCompetition(@PathVariable Integer member, @PathVariable String competition){
        Ranking ranking = rankingService.getByMemberAndCompetition(member, competition);
        if(ranking == null) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", RankingResponseDTO.fromRanking(ranking));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody RegisterMemberRequestDTO ranking){
        Ranking ranking1 = rankingService.save(ranking.toRanking());
        if (ranking1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Ranking created successfully", RankingResponseDTO.fromRanking(ranking1));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody RegisterMemberRequestDTO ranking){
        Ranking ranking1 = rankingService.update(ranking.toRanking());
        if (ranking1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Ranking updated successfully", RankingResponseDTO.fromRanking(ranking1));
    }

    @DeleteMapping("/{competition}/{member}")
    public ResponseEntity delete(@PathVariable("competition") Long competition, @PathVariable("member") Long member){
        Ranking ranking=new Ranking();
        ranking.setId(new RankId(member, competition));
        rankingService.delete(ranking);
        return ResponseMessage.ok("Ranking deleted successfully", RankingResponseDTO.fromRanking(ranking));
    }
}
