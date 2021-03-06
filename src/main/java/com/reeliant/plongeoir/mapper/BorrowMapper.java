package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.BorrowDTO;
import com.reeliant.plongeoir.entity.Borrow;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses={BookMapper.class,UserMapper.class}, componentModel = "spring")
public interface BorrowMapper{
    BorrowDTO borrowToBorrowDTO(Borrow borrow);
    Borrow borrowDTOToBorrow(BorrowDTO borrow);
}
