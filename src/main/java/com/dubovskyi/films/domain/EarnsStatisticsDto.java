package com.dubovskyi.films.domain;

import lombok.Data;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Data
@SqlResultSetMapping(
        name = "filmEarnStatistics",
        classes = {
                @ConstructorResult(
                        targetClass = EarnsStatisticsDto.class,
                        columns = {
                                @ColumnResult(name = "sum"),
                                @ColumnResult(name = "fk_cinema"),
                                @ColumnResult(name = "period")
                        }
                )
        }
)
/*@NamedNativeQuery(name="calculatesEarnsStatistics", query="SELECT sum(price),fk_cinema,'morning' AS period\n" +
        "FROM films.session a\n" +
        "LEFT JOIN films.ticket b ON a.fk_film = b.ticket_id\n" +
        "WHERE fk_cinema= 1 AND EXTRACT(HOUR FROM  begin) >= 9 AND EXTRACT(HOUR FROM  end_session) <= 12\n" +
        "GROUP BY fk_cinema\n" +
        "UNION\n" +
        "SELECT sum(price),fk_cinema,'day' AS period\n" +
        "FROM films.session a\n" +
        "  LEFT JOIN films.ticket b ON a.fk_film = b.ticket_id\n" +
        "WHERE fk_cinema= 1 AND EXTRACT(HOUR FROM  begin) > 12 AND EXTRACT(HOUR FROM  end_session) <= 18\n" +
        "GROUP BY fk_cinema\n" +
        "UNION\n" +
        "SELECT sum(price),fk_cinema,'evening' AS period\n" +
        "FROM films.session a\n" +
        "  LEFT JOIN films.ticket b ON a.fk_film = b.ticket_id\n" +
        "WHERE fk_cinema= 1 AND EXTRACT(HOUR FROM  begin) > 18 AND EXTRACT(HOUR FROM  end_session) <= 24\n" +
        "GROUP BY fk_cinema", resultSetMapping ="filmEarnStatistics")*/
public class EarnsStatisticsDto {

    private long sum;
    private long fk_cinema;
    private String period;

    public EarnsStatisticsDto() {
    }

    public EarnsStatisticsDto(long sum, long fk_cinema, String period) {
        this.sum = sum;
        this.fk_cinema = fk_cinema;
        this.period = period;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getFk_cinema() {
        return fk_cinema;
    }

    public void setFk_cinema(long fk_cinema) {
        this.fk_cinema = fk_cinema;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
