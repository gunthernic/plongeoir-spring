package com.reeliant.plongeoir.mapper;

import com.reeliant.plongeoir.dto.CategoryDTO;
import com.reeliant.plongeoir.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper{
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO category);
}
