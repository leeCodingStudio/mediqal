package com.mediqal.community.service;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("admin")
public class AdminBoardService implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public void register(BoardDTO boardDTO) {
        boardDAO.set(boardDTO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        boardDAO.set(boardDTO);
    }

    @Override
    public void remove(Long boardNumber) {
        boardDAO.remove(boardNumber);
    }

    @Override
    public BoardDTO show(Long boardNumber) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.create(boardDAO.findByIdTest(boardNumber));
        return boardDTO;
    }

    @Override
    public List<BoardDTO> showAll(Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }

    public List<BoardDTO> showAll(BoardDTO boardDTO) {
        return boardDAO.findAll(boardDTO);
    }

    public int getTotal(BoardDTO boardDTO) {
        return boardDAO.findCountAll(boardDTO);
    }
}
